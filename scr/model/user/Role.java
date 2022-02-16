package model.user;

public enum Role {
    ADMIN("ADMIN"),
    USER("USERS");

    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Role fromValue(String value) {
        Role[] values = values();
        for (Role role : values) {
            if (role.value.equals(value)) {
               return role;
            }
        }
        throw new IllegalArgumentException("invalid");
    }
}
