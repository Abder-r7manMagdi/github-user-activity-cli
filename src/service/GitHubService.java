package service;

import model.GitHubEvent;
import java.util.ArrayList;
import java.util.List;

public class GitHubService {

    // تحول JSON خام لكائنات GitHubEvent
    public List<GitHubEvent> parseEvents(String jsonData) {
        List<GitHubEvent> events = new ArrayList<>();

        // فصل كل حدث في JSON
        String[] eventItems = jsonData.split("\\},\\{");

        for(String item : eventItems) {
            // إزالة الأقواس الزائدة
            item = item.replaceAll("\\[|\\]|\\{|\\}", "");

            // type
            String type = extractValue(item, "type");

            // repo name
            String repoName = extractValue(item, "name");

            // action (لـ IssuesEvent)
            String action = extractValue(item, "action");

            // created_at
            String createdAt = extractValue(item, "created_at");

            // commit count (لـ PushEvent)
            int commitCount = countCommits(item);

            // إنشاء كائن GitHubEvent
            GitHubEvent event = new GitHubEvent(
                    extractValue(item, "id"), // id
                    type,
                    "",      // actor مش مهم دلوقتي
                    repoName,
                    "",      // payload مش مهم دلوقتي
                    true,    // isPublic افتراضي
                    createdAt
            );

            // حط عدد الـ commits أو action كـ extra info لو حابب
            events.add(event);
        }

        return events;
    }

    // دالة بسيطة لاستخراج القيمة بين key:value
    private String extractValue(String text, String key) {
        String pattern = "\"" + key + "\":\"";
        int index = text.indexOf(pattern);
        if(index == -1) return "";
        int start = index + pattern.length();
        int end = text.indexOf("\"", start);
        return text.substring(start, end);
    }

    // عدّ commits للـ PushEvent
    private int countCommits(String text) {
        String key = "\"commits\":[";
        int index = text.indexOf(key);
        if(index == -1) return 0;
        int start = index + key.length();
        int end = text.indexOf("]", start);
        String commitsArray = text.substring(start, end);
        if(commitsArray.trim().isEmpty()) return 0;
        return commitsArray.split(",").length;
    }
}
