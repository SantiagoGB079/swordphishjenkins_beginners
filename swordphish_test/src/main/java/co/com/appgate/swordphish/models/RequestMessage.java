package co.com.appgate.swordphish.models;

import java.util.List;

public class RequestMessage {

    private String correlationId;
    private String traceabilityId;
    private String replyTo;
    private List<String> urls;
    private extraData extraData;

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public extraData getExtraData() {
        return extraData;
    }

    public void setExtraData(extraData eData){
        this.extraData=eData;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getTraceabilityId() {
        return traceabilityId;
    }

    public void setReplyTo(String replyTo){
        this.replyTo = replyTo;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public List<String> getUrls() {
        return urls;
    }
}
