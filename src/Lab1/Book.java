package Lab1;

class Book {
    private String title;
    private String language;
    private String author;
    private String level;

    public Book(String title, String language, String author, String level) {
        this.title = title;
        this.language = language;
        this.author = author;
        this.level = level;
    }

    @Override
    public String toString() {
        if (language.equals("English")) {
            return title + " by " + author + " (" + level + ")";
        } else {
            return title;
        }
    }
}