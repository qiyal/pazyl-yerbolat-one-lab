package kz.one.tech.prac.one.onetechpracone.model;

public class Group {
    private String name;
    private Integer numberCount;
    private Professor supervisor;

    Group() {}

    public static GroupBuilder groupBuilder() {
        return new Group().new GroupBuilder();
    }

    public class GroupBuilder {

        private GroupBuilder() {}

        public GroupBuilder name(String name) {
            Group.this.name = name;
            return this;
        }

        public GroupBuilder numberCount(Integer numberCount) {
            Group.this.numberCount = numberCount;
            return this;
        }

        public GroupBuilder supervisor(Professor supervisor) {
            Group.this.supervisor = supervisor;
            return this;
        }

        public Group build() {
            return Group.this;
        }
    }

    // getters
    public String getName() {
        return name;
    }

    public Integer getNumberCount() {
        return numberCount;
    }

    public Professor getSupervisor() {
        return supervisor;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberCount(Integer numberCount) {
        this.numberCount = numberCount;
    }

    public void setSupervisor(Professor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", numberCount=" + numberCount +
                ", supervisor=" + supervisor +
                '}';
    }
}
