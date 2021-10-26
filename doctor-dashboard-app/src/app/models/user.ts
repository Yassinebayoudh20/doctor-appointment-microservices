export class User {
  username: string;
  email: string;
  password: string;
  about: string;
  address: string;
  phone: string;
  roles?: any[];

  constructor(username, email, password, roles) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }
}
