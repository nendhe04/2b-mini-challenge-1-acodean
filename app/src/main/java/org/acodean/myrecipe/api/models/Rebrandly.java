package org.acodean.myrecipe.api.models;

public class Rebrandly {
    String id, title, slashtag, destination,createdAt, updatedAt, status, tags, clicks, isPublic,
            shortUrl, domainId, domainName, domain, https, favourite, creator, integrated;

    public Rebrandly(String id, String title, String slashtag, String destination, String createdAt, String updatedAt, String status, String tags, String clicks, String isPublic, String shortUrl, String domainId, String domainName, String domain, String https, String favourite, String creator, String integrated) {
        this.id = id;
        this.title = title;
        this.slashtag = slashtag;
        this.destination = destination;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.tags = tags;
        this.clicks = clicks;
        this.isPublic = isPublic;
        this.shortUrl = shortUrl;
        this.domainId = domainId;
        this.domainName = domainName;
        this.domain = domain;
        this.https = https;
        this.favourite = favourite;
        this.creator = creator;
        this.integrated = integrated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlashtag() {
        return slashtag;
    }

    public void setSlashtag(String slashtag) {
        this.slashtag = slashtag;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getIntegrated() {
        return integrated;
    }

    public void setIntegrated(String integrated) {
        this.integrated = integrated;
    }
}
