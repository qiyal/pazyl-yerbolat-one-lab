package kz.one.tech.prac.one.onetechpracone.model;

public class Group {
    private String name;
    private Integer memberCount;
    private Professor supervisor;

    public Group() {}

    public static GroupBuilder groupBuilder() {
        return new Group().new GroupBuilder();
    }

    public class GroupBuilder {

        private GroupBuilder() {}

        public GroupBuilder name(String name) {
            Group.this.name = name;
            return this;
        }

        public GroupBuilder memberCount(Integer memberCount) {
            Group.this.memberCount = memberCount;
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

    public Integer getMemberCount() {
        return memberCount;
    }

    public Professor getSupervisor() {
        return supervisor;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public void setSupervisor(Professor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", supervisor=" + supervisor +
                '}';
    }
}
