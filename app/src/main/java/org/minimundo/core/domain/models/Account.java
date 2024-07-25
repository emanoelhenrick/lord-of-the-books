package org.minimundo.core.domain.models;

import java.time.LocalDateTime;

public class Account {
  private String id;
  private String username;
  private String email;
  private String password;
  private LocalDateTime createdAt;

  private UserData data;
}
