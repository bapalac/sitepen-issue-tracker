export interface PlaceholderData {
	placeholderId: number;
	placeholderString: string;
}

export interface Task {
	id: number;
	title: string;
	status: 'OPEN' | 'IN_PROGRESS' | 'CLOSED';
	priority: 'LOW' | 'MEDIUM' | 'HIGH';
}