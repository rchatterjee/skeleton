package dao;

import generated.tables.Receipts;
import generated.tables.Tags;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.tables.Tags.TAGS;
import static generated.tables.Receipts.RECEIPTS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public List<ReceiptsRecord> getAllReceipts(String tag) {
        return dsl.selectFrom(RECEIPTS).where(RECEIPTS.ID.in(dsl.select(TAGS.RECEIPT_ID)
                .from(TAGS.innerJoin(RECEIPTS).on(TAGS.RECEIPT_ID.eq(RECEIPTS.ID)))
                .where(TAGS.TAG.eq(tag)))).fetch();
    }


    public void insert_or_delete(String tag, int receipt_id) {
        if (dsl.fetchOne("select * from receipts where id=" + receipt_id) != null) {
            if(dsl.fetchOne("select 1 from tags where tag='" + tag + "' and receipt_id="+receipt_id) != null) {
                System.out.println(">>>>> Deleting tag!! " + tag);
                dsl.deleteFrom(TAGS).where(TAGS.TAG.eq(tag).and(TAGS.RECEIPT_ID.eq(receipt_id))).execute();
            }
            else {
                System.out.println(">>>>> Inserting tag!! " + tag);
                dsl.insertInto(TAGS, TAGS.TAG, TAGS.RECEIPT_ID)
                        .values(tag, receipt_id).returning().execute();
            }
        }
    }

    public List<String> getTags(int receipt_id) {
        return dsl.selectFrom(TAGS).where(TAGS.RECEIPT_ID.eq(receipt_id)).fetch(TAGS.TAG);
    }
}
