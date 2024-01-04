INSERT INTO user_profiles (name, created_at) VALUES
    ('DEVELOPER', NOW()),
    ('RECRUITER', NOW());

INSERT INTO url_supported_platforms (name, label, logo, created_at, updated_at) VALUES
    ('linkedin', 'LinkedIn', '', NOW(), NOW()),
    ('github', 'Github', '', NOW(), NOW());