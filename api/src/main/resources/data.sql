INSERT INTO user_entity (id, first_name, last_name, role, email)
VALUES (1, 'brittany', 'palac', 'ADMIN', 'brittany.a.palac@gmail.com');

INSERT INTO issue_entity (id, title, description, status, priority, assignee_id, project_id)
VALUES (1, 'Fix login bug', 'Fix login bug description', 'IN_PROGRESS', 'HIGH', 1, 1),
       (2, 'Write landing page content', 'content description', 'OPEN', 'MEDIUM', 1, 1),
       (3, 'Refactor task service', 'refactor description', 'CLOSED', 'LOW', 1, 1);

INSERT INTO project_entity (id, owner_id, name)
VALUES (1, 1, 'Assessment')