export class SignUpRequest {
  public constructor (public username: string, public password: string, public confirmPassword: string, public email: string) {}
}
