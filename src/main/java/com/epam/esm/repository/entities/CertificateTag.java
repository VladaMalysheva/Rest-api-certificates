package com.epam.esm.repository.entities;

public class CertificateTag {
    private int id;
    private int tagId;
    private int certificateId;

    public CertificateTag(int id, int tagId, int certificateId) {
        this.id = id;
        this.tagId = tagId;
        this.certificateId = certificateId;
    }

    public CertificateTag(int tagId, int certificateId) {
        this.tagId = tagId;
        this.certificateId = certificateId;
    }

    public CertificateTag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    @Override
    public String toString() {
        return "CertificateTag{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", certificateId=" + certificateId +
                '}';
    }
}
