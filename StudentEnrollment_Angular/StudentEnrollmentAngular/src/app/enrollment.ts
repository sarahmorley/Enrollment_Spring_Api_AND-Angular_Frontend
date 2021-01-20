export interface IEnrollment {
    courseId: string;
    studentId: string;
}

export class Enrollment implements IEnrollment {
    courseId: string;
    studentId: string;
}