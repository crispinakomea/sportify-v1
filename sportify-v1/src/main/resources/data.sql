INSERT INTO LEAGUES (`division`, `name`, `season_start`, `season_end`)
VALUES 
('E0', 'English Premier League', '2017-08-11', '2018-05-13'),
('E1', 'English Championship', '2017-08-04', '2018-05-06'),
('E2', 'English League One', '2017-08-05', '2018-05-05'),
('E3', 'English League Two', '2017-08-05', '2018-05-05'),
('F1', 'France Ligue 1', '2017-08-04', '2018-05-19'),
('D1', 'German Bundesliga', '2017-08-18', '2018-05-12'),
('I1', 'Italy Serie A', '2017-08-19', '2018-05-20'),
('SP1', 'Spanish La Liga', '2017-08-18', '2018-05-20'),
('N1', 'Holland Eredivisie', '2017-08-11', '2018-05-06'),
('B1', 'Belgium First Division A', '2017-07-28', '2018-06-30'),
('P1', 'Portugal Primeira Liga', '2017-08-06', '2018-05-12'),
('T1', 'Turkish Süper Lig', '2017-08-11', '2018-05-20'),
('SC0', 'Scotland Premiership', '2017-08-05', '2018-04-07');

INSERT INTO TEAMS (`league_id`, `name`, `alias`, `stadium`)
VALUES
((SELECT id from LEAGUES WHERE name='English Premier League'), 'AFC Bournemouth', 'Bournemouth', 'Dean Court'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Arsenal', 'Arsenal', 'Emirates Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Brighton & Hove Albion', 'Brighton', 'Falmer Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Burnley', 'Burnley', 'Turf Moor'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Chelsea', 'Chelsea', 'Stamford Bridge'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Crystal Palace', 'Crystal Palace', 'Selhurst Park'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Everton', 'Everton', 'Goodison Park'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Huddersfield Town', 'Huddersfield', 'John Smith''s Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Leicester City', 'Leicester',  'King Power Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Liverpool', 'Liverpool', 'Anfield'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Manchester City', 'Man City', 'Etihad Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Manchester United', 'Man United', 'Old Trafford'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Newcastle United', 'Newcastle', 'St James'' Park'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Southampton', 'Southampton', 'St Mary''s Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Stoke City', 'Stoke', 'bet365 Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Swansea City', 'Swansea', 'Liberty Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Tottenham Hotspur', 'Tottenham', 'Wembley Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Watford', 'Watford', 'Vicarage Road'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'West Bromwich Albion', 'West Brom', 'The Hawthorns'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'West Ham United', 'West Ham', 'London Stadium');