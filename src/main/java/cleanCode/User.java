package cleanCode;

import java.util.Objects;

public final class User {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final int age;

    public User(String id, String name, String email, String phone, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getAge() {
        return this.age;
    }


    public String toString() {
        return "User{id='" + this.id + "', name='" + this.name + "', email='" + this.email + "', age=" + this.age + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null && this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }
}
