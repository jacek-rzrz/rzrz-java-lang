function range(s, e) { var r = []; for(var i=s; i<=e; i++) r.push(i); return r; }

function nonEmpty(o) {
	return o !== 0 && o !== '';
}

function delim(arg1, op, arg2) {
	var n1 = nonEmpty(arg1);
	var n2 = nonEmpty(arg2);
	var delim;
	if (op === '&') {
		delim = n1 && n2;
	}
	else {
		if (op === '|') {
			delim =  n1 || n2;
		}
		else {
		 console.log('Unrecognized operator:  ' + op);
		}
	}
	return delim ? ', ' : '';
}

function lang(numParams, returnType) {

	return numParams > 0 || returnType.length > 0 ? '<' : '';
}

function rang(numParams, returnType) {

	return numParams > 0 || returnType.length > 0 ? '>' : '';
}

function args(range) {
	return range.map(function(i) { return 'T' + i + ' $' + i }).join(', ');
}

function typeParams(range) {
	return range.map(function(i) { return 'T' + i }).join(', ');
}

function tuple(range) {
	return 'Tuple' + range.length + '<' + typeParams(range) + '>';
}

function mapper(range) {
	return 'Func' + range.length + '<' + typeParams(range) + ', U>';
}

function mapperThrowsT(range) {
	return 'Func' + range.length + 'ThrowsT<' + typeParams(range) + ', U, E>';
}

function consumer(range) {
	return 'Action' + range.length + '<' + typeParams(range) + '>';
}

function consumerThrowsT(range) {
	return 'Action' + range.length + 'ThrowsT<' + typeParams(range) + ', E>';
}

function passVals(range) {
	return range.map(function(i) { return '$' + i }).join(', ');
}

/*
 * Wraps a function expecting a range to accept:
 * - a tuple object:      wrap(f)(tuple)      --> f(range(1, tuple.arity))
 * - range end:           wrap(f)(end)        --> f(range(1, end))
 * - range start and end: wrap(f)(start, end) --> f(range(start, end))
 */
function wrap(f) {
	return function(start, end) {
		if(typeof(start) == typeof('')) { start = start.length }
		if(typeof(start) == typeof({})) { start = start.arity  } // it's a tuple object
		if(typeof(end) == typeof({})) { end = start; start = 1 } // only range end passed
		return f(range(start, end));
	}
}

module.exports = {
	lang: lang,
	rang: rang,
	delim: delim,
	args: wrap(args),
	typeParams: wrap(typeParams),
	passVals: wrap(passVals),
	tuple: wrap(tuple),
	mapper: wrap(mapper),
	mapperThrowsT: wrap(mapperThrowsT),
	consumer: wrap(consumer),
	consumerThrowsT: wrap(consumerThrowsT)
};

