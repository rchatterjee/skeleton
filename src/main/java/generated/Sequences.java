/**
 * This class is generated by jOOQ
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.system_sequence_f79cd42a_4643_43ce_a2b6_7d08ec55b084</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_F79CD42A_4643_43CE_A2B6_7D08EC55B084 = new SequenceImpl<Long>("system_sequence_f79cd42a_4643_43ce_a2b6_7d08ec55b084", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
