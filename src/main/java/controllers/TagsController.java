package controllers;

import api.ReceiptResponse;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagsController {
    final TagDao tags;

    public TagsController(TagDao tags) {
        this.tags = tags;
    }

    @PUT
    public void addTag(@PathParam("tag") String tag, int receipt_id) {
        tags.insert_or_delete(tag, receipt_id);
    }

    @GET
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tag) {
        List<ReceiptsRecord> receiptRecords = tags.getAllReceipts(tag);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}
