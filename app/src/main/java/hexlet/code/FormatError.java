package hexlet.code;

public final class FormatError extends Exception {
    private final String file;

    FormatError(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return file;
    }
}
