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
		path: 'tasks',
		loadComponent: () => import('./features/task-list/task-list').then(m => m.TaskListComponent)
	},
	{ 
		path: '**', 
		loadComponent: () => import('./landing/landing').then(m => m.LandingComponent)
	}
];
