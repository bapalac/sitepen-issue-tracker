import { Routes } from '@angular/router';


export const routes: Routes = [
	{
		path: '',
		loadComponent: () => import('./landing/landing').then(m => m.LandingComponent)
	},
	{ 
		path: 'placeholder', 
		loadComponent: () => import('./features/placeholder/placeholder').then(m => m.PlaceholderComponent)
	},
	{
		path: 'projects',
		loadComponent: () => import('./features/project-list/project-list').then(m => m.ProjectListComponent)
	},
	{
		path: 'project/:projectId',
		loadComponent: () => import('./features/project-details/project-details').then(m => m.ProjectDetailsComponent)
	},
	{
		path: 'tasks',
		loadComponent: () => import('./features/task-list/task-list').then(m => m.TaskListComponent)
	},
	{
		path: 'task/:taskId',
		loadComponent: () => import('./features/task-details/task-details').then(m => m.TaskDetailsComponent)
	},
	{ 
		path: '**', 
		loadComponent: () => import('./landing/landing').then(m => m.LandingComponent)
	}
];
