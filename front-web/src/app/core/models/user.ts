import { UserI } from "../interfaces/user-i";
import { Report } from "./report";

export class User implements UserI {
    userID!: number;
    pseudo!: String;
    email!: String;
    mdp!: String;
    reports!: [Report];

    constructor(userObj?: Partial<User>) {
        if (userObj) {
            Object.assign(this, userObj);
        }
    }
}