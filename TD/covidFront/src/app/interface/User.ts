import { Role } from "./Role";

export interface User {
    token: string;
    authdata: string;
    id: number,
    login : string,
    password: string,
    roles: Role,
}
