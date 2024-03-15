package Lab1;

class UniversityLibraryFactory implements LibraryFactory {
    @Override
    public Book createTextbook(String title, String language) {
        if (language.equals("English")) {
            return new Book(title, language, "Author", "Bachelor");
        } else {
            return new Book(title, language, null, null);
        }
    }

    @Override
    public Book createFictionBook(String title, String language) {
        if (language.equals("English")) {
            return new Book(title, language, "Director", null);
        } else {
            return new Book(title, language, "Директор", null);
        }
    }
}