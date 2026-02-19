export interface User {
	id: number;
	firstName: string;
	lastName: string;
	role: 'ADMIN' | 'MANAGER' | 'USER';
	email: string;
}

export interface Issue {
	id: number;
	title: string;
	description: string;
	status: 'OPEN' | 'IN_PROGRESS' | 'CLOSED';
	priority: 'LOW' | 'MEDIUM' | 'HIGH';
	assigneeId: number;
	projectId: number;
}

export interface Project {
	id: number;
	ownerId: number;
	name: string;
}