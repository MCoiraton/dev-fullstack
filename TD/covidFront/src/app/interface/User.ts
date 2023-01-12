import { Role } from "./Role";

export interface User {
    id: number,
    login : string,
    password: string,
    roles: Role,
}
