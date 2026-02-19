import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TaskListComponent } from './task-list';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';

describe('TaskListComponent', () => {
  let component: TaskListComponent;
  let fixture: ComponentFixture<TaskListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskListComponent, MatCardModule, MatButtonModule, CommonModule]
    }).compileComponents();

    fixture = TestBed.createComponent(TaskListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render mock tasks', () => {
	component.taskList.set([
		{ id: 1, title: 'Fix login bug', status: 'IN_PROGRESS', priority: 'HIGH' }
	]);

    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    const cards = compiled.querySelectorAll('mat-card');
    expect(cards.length).toBeGreaterThan(0);
    expect(cards[0].textContent).toContain('Fix login bug');
  });

  it('should mark a task as DONE when markDone is called', () => {
	component.taskList.set([
		{ id: 1, title: 'Fix login bug', status: 'IN_PROGRESS', priority: 'HIGH' }
	]);
    const firstTask = component.taskList()[0];
    expect(firstTask.status).not.toBe('DONE');

    component.markDone(firstTask);

    expect(firstTask.status).toBe('DONE');
  });
});
