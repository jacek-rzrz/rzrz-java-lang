var fs = require('fs')
var handlebars = require('handlebars')
var path = require('path')
var helpers = require('./helpers')

// register functions defined in helpers.js:
// they will be available in the templates:
for(var helper in helpers) {
	handlebars.registerHelper(helper, helpers[helper]);
}

function range(s, e) { var r = []; for(var i=s; i<=e; i++) r.push(i); return r; }

var maxLength = 10;

function createTuple(arity) {
  var t = {}
  t.arity = arity
  t.args = range(1, arity)
  t.skips = range(1, arity-2).map(function(i) { return { skip: i, first: i+1, arity: arity-i }})
  t.takes = range(2, arity-1)
  if(arity < maxLength)
	t.inserts = range(2, arity).map(function(i) { return { index: i, arity: arity+1, before:i-1, after: arity-i }})
  else
	t.inserts = []
  if(arity > 2)
	t.removes = range(2, arity-1).map(function(i) { return { index: i, arity: arity-1, before:i-1, after: arity-i, afterStart:i+1 }})
  else
	t.removes = []
  if(arity <= maxLength-2)
	t.concats = range(2, maxLength-arity).map(function(i) { return { arity: arity+i, start: arity+1, end: arity+i, range: range(1, i) }})
  else
	t.concats = []
  return t
}

var params = {}

params.exceptions = [
  { name: "ArrayIndexOutOfBounds", cause: false, package: false },
  { name: "ArrayStore", cause: false, package: false },
  { name: "IllegalAccess", cause: false, package: false },
  { name: "IllegalArgument", cause: true, package: false },
  { name: "IllegalState", cause: true, package: false },
  { name: "IndexOutOfBounds", cause: false, package: false},
  { name: "NegativeArraySize", cause: false, package: false },
  { name: "NoSuchElement", cause: false, package: "java.util"},
  { name: "NullPointer", cause: false, package: false },
  { name: "NumberFormat", cause: false, package: false },
  { name: "StringIndexOutOfBounds", cause: false, package: false },
  { name: "UnsupportedOperation", cause: true, package: false }
];

params.arities = range(0, maxLength)
params.maxLength = maxLength
params.functions = range(1, params.maxLength).map(function(i) { return { arity: i, args: range(1, i) } })

function Function(params) {
  this.name = params.name;
  this.ret = params.ret;
}

params.functions = [
  {
	name: { long:'Function', short: 'Func'},
	ret: { type: 'TResult', param: 'TResult' }
  },
  {
	name: { long:'Action', short: 'Action'},
	ret: { type: 'void', param: '' }
  },
  {
	name: { long:'Predicate', short: 'Predicate'},
	ret: { type: 'boolean', param:'' }
  }
].map(function(p) { return new Function(p); });

params.tuples  = range(2, params.maxLength).map(createTuple)


for(var i=1; i<params.maxLength-1; i++) {
  params.tuples[i-1].next = params.tuples[i]
}

[
	'main/java/rzrz/java/lang/Exceptions',
	'main/java/rzrz/java/lang/Functions',
	'main/java/rzrz/java/lang/Tuples'
].forEach(function(what) {

  fs.readFile(path.resolve(__dirname, what+'Template.java'), 'UTF-8', function(err, templateText) {

	if(err) throw err

	var template = handlebars.compile(
		  templateText.toString(),
		  { strict: true, noEscape: true  }
	)

	var output = template(params)

	var outputPath = path.resolve('src', what + ".java")

	fs.writeFile(outputPath, output, function(err) {
	  if(err) throw err
	  console.log('Output written to ' + outputPath)
	})
  })
})