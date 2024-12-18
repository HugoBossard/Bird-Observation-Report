import { ReportI } from "../interfaces/report-i";

export class Report implements ReportI {
    reportID!: number;
    nom!: String;
    espece!: String;
    nombre!: number;
    ville!: String;
    date_pub!: Date;
    userID!: number;

    constructor(reportObj?: Partial<Report>) {
        if (reportObj) {
            Object.assign(this, reportObj);
        }
    }
}