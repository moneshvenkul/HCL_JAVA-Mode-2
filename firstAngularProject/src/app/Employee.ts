import { Skill } from "./Skill";
import { Department } from "./Department";

export interface Employee {
    id : number;
    name : string;
    date : string;
    gender : string;
    salary : number;
    permanent : boolean;
    dept : Department;
    skill : Skill[];
    dateOfBirth : Date;
}