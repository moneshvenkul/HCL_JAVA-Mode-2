import { Skill } from "./Skill";

export interface Employee {
    id : number;
    name : string;
    date : string;
    gender : string;
    salary : number;
    permanent : string;
    deptId : number;
    deptName : string;
    skill : Skill[];
    dateOfBirth : Date;
}