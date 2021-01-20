export interface ICourse {
    id: string;
    name: string;
    description: string;
}

export class Course implements ICourse {
    id: string;
    name: string;
    description: string;
}