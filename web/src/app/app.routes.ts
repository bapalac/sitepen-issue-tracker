import { Routes } from '@angular/router';


export const routes: Routes = [
	{
		path: '',
		loadComponent: () => import('./landing/landing').then(m => m.LandingComponent)
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
		path: 'issues',
		loadComponent: () => import('./features/issue-list/issue-list').then(m => m.IssueListComponent)
	},
	{
		path: 'issue/:issueId',
		loadComponent: () => import('./features/issue-details/issue-details').then(m => m.IssueDetailsComponent)
	},
	{ 
		path: '**', 
		loadComponent: () => import('./landing/landing').then(m => m.LandingComponent)
	}
];
