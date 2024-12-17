import { ReportI } from "./report-i"

export interface UserI {
    userID: number,
    pseudo: String,
    email: String,
    mdp: String,
    reports: [ReportI]
}