package model;

public class GitHubEvent {
    private String id;
    private String type;
    private String actor;      // ممكن تخزن اسم المستخدم أو JSON String
    private String repo;       // ممكن تخزن اسم الريبو أو JSON String
    private String payload;    // ممكن تخزن JSON String للـ payload
    private boolean isPublic;
    private String createdAt;

    public GitHubEvent(String id, String type, String actor, String repo, String payload, boolean isPublic, String createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.payload = payload;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
    }

    // Getters
    public String getId() { return id; }
    public String getType() { return type; }
    public String getActor() { return actor; }
    public String getRepo() { return repo; }
    public String getPayload() { return payload; }
    public boolean isPublic() { return isPublic; }
    public String getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Event Type: " + type + ", Repo: " + repo + ", Actor: " + actor + ", Created At: " + createdAt;
    }
}
