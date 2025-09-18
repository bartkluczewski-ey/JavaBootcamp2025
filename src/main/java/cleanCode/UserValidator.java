
package cleanCode;

public class UserValidator {
    private static final int MIN_AGE = 18;
    private static final int MAX_NAME_LENGTH = 20;

    public void validate(String name, String email, String phone, int age) {

        if(isInvalid(name) || name.length() > MAX_NAME_LENGTH || !name.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Invalid name. Must be 1-20 letters and containt only letters");
        }

        if(isInvalid(email) || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email, must contain '@'");
        }

        if (isInvalid(phone)) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }

        if(age<MIN_AGE){
            throw new IllegalArgumentException("User must be at least "+ MIN_AGE+" years old");
        }
    }

    private boolean isInvalid(String value){
        return value == null || value.trim().isEmpty();
    }
}
