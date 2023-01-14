import { Role } from "./Role";

export interface User {
    authdata: string;
    id: number,
    login : string,
    password: string,
    roles: Role,
}
