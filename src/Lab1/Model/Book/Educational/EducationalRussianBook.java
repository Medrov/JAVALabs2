package Lab1.Model.Book.Educational;

import Lab1.Model.Book.RussianBook;

public class EducationalRussianBook extends RussianBook {
    private final String discipline;

    public EducationalRussianBook(String type, int edition, String discipline) {
        super(type, edition);
        this.discipline = discipline;
    }

    @Override
    public String getString() {
        return String.join(" ", type, discipline, edition + "-е издание");
    }
}
