package comparison.java;

public class DTO {
    public static  class Author {
        private final String name;

        private String pseudonym;

        public Author(String name, String pseudonym) {
            this.name = name;
            this.pseudonym = pseudonym;
        }

        public String getName() {
            return name;
        }

        public String getPseudonym() {
            return pseudonym;
        }

        public void setPseudonym(String pseudonym) {
            this.pseudonym = pseudonym;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Author author = (Author) o;

            if (name != null ? !name.equals(author.name) : author.name != null) return false;
            if (pseudonym != null ? !pseudonym.equals(author.pseudonym) : author.pseudonym != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (pseudonym != null ? pseudonym.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", pseudonym='" + pseudonym + '\'' +
                    '}';
        }
    }
}
