{{! Template of Tuples.java }}
package rzrz.java.lang;

import java.util.Objects;

import rzrz.java.lang.Functions.*;

/**
 *  AUTOGENERATED FILE: DO NOT MODIFY
 *  @see src/main/templates/rzrz/java/lang/GenerateSources.js
 *  @author Jacek Rzeniewicz
 */
public final class Tuples {

	/**
	 * Top-level interface implemented by all tuples.
	 *
	 * <p>Defines static factory methods for instantiating tuples, e.g.
	 * <pre>
	 * {@code
	 * Tuple2&lt;Integer, String&gt; tup = Tuple.of(3, "Hello");
	 * }
	 * </pre>
	 */
	public interface Tuple {

		{{#each tuples}}
		/**
		 * Factory method for creating Tuple{{this.arity}} instances.
		 */
		static <{{typeParams this}}> {{tuple this}} of({{args this}}) {
			return new Tuple{{this.arity}}({{passVals this}});
		}

		{{/each}}

	}

	{{#each tuples}}

	/**
	 * Tuple of arity {{this.arity}}.
	 *
	 * <p>Objects of this class are immutable.
	 */
	public static class Tuple{{this.arity}}<{{typeParams this}}> implements Tuple {

		{{#each this.args}}
		/**
		 * Element #{{this}} (1-based indexing)
		 */
		public final T{{this}} ${{this}};
		{{/each}}

		/**
		 * Creates a new instance.
		 *
		 * <p>See also Tuples.of() for more convenient Tuple creation
		 * @see Tuple#of
		 */
		public Tuple{{this.arity}}({{args this}}) {
			{{#each this.args}}
			this.${{this}} = ${{this}};
			{{/each}}
		}

		{{#unless @last}}
		public <T{{this.next.arity}}> {{tuple this.next}} append(T{{this.next.arity}} ${{this.next.arity}}) {
			return new Tuple{{this.next.arity}}<>({{passVals this.next}});
		}

		public <T0> Tuple{{this.next.arity}}<T0, {{typeParams this}}> prepend (T0 $0) {
			return new Tuple{{this.next.arity}}<>($0, {{passVals this}});
		}
		{{/unless}}

		{{#each this.skips}}
		public {{tuple this.first ../this.arity}} skip{{this.skip}}() {
			return new Tuple{{this.arity}}<>({{passVals this.first ../this.arity}});
		}

		{{/each}}

		{{#each this.takes}}
		public {{tuple this}} take{{this}}() {
			return new Tuple{{this}}<>({{passVals this}});
		}

		{{/each}}

		{{#each this.inserts}}
		public <U> Tuple{{this.arity}}<{{typeParams this.before}}, U, {{typeParams this.index ../this.arity}}> insert{{this.index}}(U $) {
			return new Tuple{{this.arity}}<>({{passVals this.before}}, $, {{passVals this.index ../this.arity}});
		}

		{{/each}}

		{{#each this.removes}}
		public Tuple{{this.arity}}<{{typeParams this.before}}, {{typeParams this.afterStart ../this.arity}}> remove{{this.index}}() {
			return new Tuple{{this.arity}}<>({{passVals this.before}}, {{passVals this.afterStart ../this.arity}});
		}

		{{/each}}

		{{#each this.concats}}
		public <{{typeParams this.start this.end}}> Tuple{{this.arity}}<{{typeParams ../this}}, {{typeParams this.start this.end}}> concat({{tuple this.start this.end}} other) {
			return new Tuple{{this.arity}}<>({{passVals ../this}}{{#each this.range}}, other.${{this}}{{/each}});
		}

		{{/each}}

		public <U> U map({{mapper this}} mapper) {
			return mapper.call({{passVals this}});
		}

		public <U, E extends Throwable> U mapThrowing({{mapperThrowsT this}} mapper) throws E {
			return mapper.call({{passVals this}});
		}

		public {{tuple this}} consume({{consumer this}} callable) {
			callable.call({{passVals this}});
			return this;
		}

		public <E extends Throwable> {{tuple this}} consumeThrowing({{consumerThrowsT this}} callable) throws E {
			callable.call({{passVals this}});
			return this;
		}

		@Override
		public String toString() {
			return "(" + {{#each this.args}}${{this}}{{#unless @last}} + ", " + {{/unless}}{{/each}} + ")";
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(!(this instanceof Tuple{{this.arity}})) return false;
			{{tuple this}} other =
				({{tuple this}}) obj;
			{{#each this.args}}
			if(!Objects.equals(${{this}}, other.${{this}})) return false;
			{{/each}}
			return true;
		}

		@Override
		public int hashCode() {
			return Objects.hash({{passVals this}});
		}
	}

	{{/each}}
}
