# GitHub User Activity CLI

A simple **Command Line Interface (CLI)** tool to fetch and display GitHub user activity using the GitHub API.  
Built with **Java**.

---

## Features

- Fetches user activity such as:
  - Opened/closed issues
  - Issue comments
  - Pull requests
  - Starred repositories
  - Pushed commits
- Displays activity in a readable format directly in the terminal.
- Lightweight and easy to use.

---

## Installation

1. Clone this repository:
```bash
git clone https://github.com/Abder-r7manMagdi/github-user-activity-cli.git
```

2. Navigate to the project folder:
```bash
cd "GitHub User Activity"
```

3. Compile the Java source:
```bash
javac -d out/production/GitHubUserActivity src/*.java src/model/*.java src/service/*.java src/repository/*.java
```

## Usage
Run the CLI tool by providing a GitHub username:
```bash
java -cp "out/production/GitHubUserActivity" Main <GitHub-username>
```

Example:

```bash
java -cp "out/production/GitHubUserActivity" Main Abder-r7manMagdi
```

Or, if using the provided PowerShell script:

```powershell
.\runGitHubActivity.ps1 -username Abder-r7manMagdi
```

## Project Structure

```kotlin
src/
  Main.java
  model/
    GitHubEvent.java
  service/
    GitHubService.java
  repository/
    GitHubRepository.java
runGitHubActivity.ps1
out/           # Compiled .class files
.gitignore
```

## Dependencies
Java 24 or higher

Internet connection (to access GitHub API)

GitHub Personal Access Token (optional if hitting API rate limits)

## License
This project is licensed under the MIT License.

## Author
Abder-r7manMagdi
[GitHub Profile](https://github.com/Abder-r7manMagdi/)
