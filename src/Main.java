import model.GitHubEvent;
import repository.GitHubRepository;
import service.GitHubService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage: java Main <GitHub username>");
            return;
        }

        String username = args[0];

        GitHubRepository repo = new GitHubRepository();
        GitHubService service = new GitHubService();

        try {
            // جلب البيانات الخام من GitHub API
            String jsonData = repo.fetchEvents(username);

            // تحويل JSON لكائنات GitHubEvent
            List<GitHubEvent> events = service.parseEvents(jsonData);

            // عرض النشاطات بشكل جميل
            for(GitHubEvent event : events) {
                String output = formatEvent(event);
                System.out.println(output);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // دالة لتحويل GitHubEvent لسطر مفهوم للتيرمنال
    private static String formatEvent(GitHubEvent event) {
        String type = event.getType();
        String repoName = event.getRepo();
        String createdAt = event.getCreatedAt();

        switch(type) {
            case "PushEvent":
                // هنا نقدر نضيف عدد commits لو Service رجعها
                return "Pushed commits to " + repoName + " at " + createdAt;
            case "CreateEvent":
                return "Created a new repo/event in " + repoName + " at " + createdAt;
            case "IssuesEvent":
                return "Opened/Closed an issue in " + repoName + " at " + createdAt;
            case "WatchEvent":
                return "Starred " + repoName + " at " + createdAt;
            default:
                return type + " in " + repoName + " at " + createdAt;
        }
    }
}
