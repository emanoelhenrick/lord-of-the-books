package org.minimundo.core.domain.models;

import java.time.LocalDateTime;

public class Account {
  public String id;
  public String username;
  public String email;
  public String password;
  public LocalDateTime createdAt;

  public UserData data;
}
