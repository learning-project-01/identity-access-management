package rbac.service.framework.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class User {

  private String email;
  private String firstName;
  private String lastName;
  private Long createdMillis;
  private Boolean status;

  public String getEmail() {
    return email == null ? null : email.toLowerCase();
  }

  public void setEmail(String email) {
    this.email = email == null ? null : email.toLowerCase();
  }

  @Override
  public int hashCode() {
    return getEmail().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    User user = User.class.cast(obj);
    return this.getEmail().equals(user.getEmail());
  }
}
