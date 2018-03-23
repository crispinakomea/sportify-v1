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
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Huddersfield Town', 'Huddersfield', 'John Smiths Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Leicester City', 'Leicester',  'King Power Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Liverpool', 'Liverpool', 'Anfield'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Manchester City', 'Man City', 'Etihad Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Manchester United', 'Man United', 'Old Trafford'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Newcastle United', 'Newcastle', 'St James Park'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Southampton', 'Southampton', 'St Marys Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Stoke City', 'Stoke', 'bet365 Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Swansea City', 'Swansea', 'Liberty Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Tottenham Hotspur', 'Tottenham', 'Wembley Stadium'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'Watford', 'Watford', 'Vicarage Road'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'West Bromwich Albion', 'West Brom', 'The Hawthorns'),
((SELECT id from LEAGUES WHERE name='English Premier League'), 'West Ham United', 'West Ham', 'London Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Aston Villa', 'Aston Villa', 'Villa Park'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Barnsley', 'Barnsley', 'Oakwell'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Birmingham City', 'Birmingham', 'St Andrews'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Bolton Wanderers', 'Bolton', 'Macron Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Brentford', 'Brentford', 'Griffin Park'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Bristol City', 'Bristol City', 'Ashton Gate'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Burton Albion', 'Burton', 'Pirelli Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Cardiff City', 'Cardiff', 'Cardiff City Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Derby County', 'Derby', 'Pride Park Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Fulham', 'Fulham', 'Craven Cottage'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Hull City', 'Hull', 'KCOM Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Ipswich Town', 'Ipswich', 'Portman Road'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Leeds United', 'Leeds', 'Elland Road'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Middlesbrough', 'Middlesbrough', 'Riverside Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Millwall', 'Millwall', 'The Den'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Norwich City', 'Norwich', 'Carrow Road'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Nottingham Forest', 'Nott''m Forest', 'City Ground'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Preston North End', 'Preston', 'Deepdale'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Queens Park Rangers', 'QPR', 'Loftus Road'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Reading', 'Reading', 'Madejski Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Sheffield United', 'Sheffield United', 'Bramall Lane'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Sheffield Wednesday', 'Sheffield Weds', 'Hillsborough Stadium'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Sunderland', 'Sunderland', 'Stadium of Light'),
((SELECT id from LEAGUES WHERE name='English Championship'), 'Wolverhampton Wanderers', 'Wolves', 'Molineux'),
((SELECT id from LEAGUES WHERE name='English League One'), 'AFC Wimbledon', 'AFC Wimbledon', 'Kingsmeadow'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Blackburn Rovers', 'Blackburn', 'Ewood Park'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Blackpool', 'Blackpool', 'Bloomfield Road'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Bradford City', 'Bradford', 'Valley Parade'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Bristol Rovers', 'Bristol Rvs', 'Memorial Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Bury', 'Bury', 'Gigg Lane'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Charlton Athletic', 'Charlton', 'The Valley'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Doncaster Rovers', 'Doncaster', 'Keepmoat Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Fleetwood Town', 'Fleetwood Town', 'Highbury Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Gillingham', 'Gillingham', 'Priestfield Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Milton Keynes Dons', 'Milton Keynes Dons', 'Stadium:mk'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Northampton Town', 'Northampton', 'Sixfields Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Oldham Athletic', 'Oldham', 'Boundary Park'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Oxford United', 'Oxford', 'Kassam Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Peterborough United', 'Peterboro', 'London Road'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Plymouth Argyle', 'Plymouth', 'Home Park'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Portsmouth', 'Portsmouth', 'Fratton Park'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Rochdale', 'Rochdale', 'Spotland Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Rotherham United', 'Rotherham', 'New York Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Scunthorpe United', 'Scunthorpe', 'Glanford Park'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Shrewsbury Town', 'Shrewsbury', 'New Meadow'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Southend United', 'Southend', 'Roots Hall'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Walsall', 'Walsall', 'Bescot Stadium'),
((SELECT id from LEAGUES WHERE name='English League One'), 'Wigan Athletic', 'Wigan', 'DW Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Accrington Stanley', 'Accrington', 'Crown Ground'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Barnet', 'Barnet', 'The Hive Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Cambridge United', 'Cambridge', 'Abbey Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Carlisle United', 'Carlisle', 'Brunton Park'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Cheltenham Town', 'Cheltenham', 'Whaddon Road'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Chesterfield', 'Chesterfield', 'Proact Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Colchester United', 'Colchester', 'Colchester Community Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Coventry City', 'Coventry', 'Ricoh Arena'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Crawley Town', 'Crawley Town', 'Broadfield Stadium'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Crewe Alexandra', 'Crewe', 'Gresty Road'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Exeter City', 'Exeter', 'St James Park'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Forest Green Rovers', 'Forest Green', 'The New Lawn'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Grimsby Town', 'Grimsby', 'Blundell Park'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Lincoln City', 'Lincoln', 'Sincil Bank'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Luton Town', 'Luton', 'Kenilworth Road'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Mansfield Town', 'Mansfield', 'Field Mill'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Morecambe', 'Morecambe', 'Globe Arena'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Newport County', 'Newport County', 'Rodney Parade'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Notts County', 'Notts County', 'Meadow Lane'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Port Vale', 'Port Vale', 'Vale Park'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Stevenage', 'Stevenage', 'Broadhall Way'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Swindon Town', 'Swindon', 'County Ground'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Wycombe Wanderers', 'Wycombe', 'Adams Park'),
((SELECT id from LEAGUES WHERE name='English League Two'), 'Yeovil Town', 'Yeovil', 'Huish Park'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Amiens', 'Amiens', 'Stade de la Licorne'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Angers', 'Angers', 'Stade Raymond Kopa'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Bordeaux', 'Bordeaux', 'Matmut Atlantique'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Caen', 'Caen', 'Stade Michel dOrnano'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Dijon', 'Dijon', 'Stade Gaston Gérard'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Guingamp', 'Guingamp', 'Stade du Roudourou'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Lille', 'Lille', 'Stade Pierre-Mauroy'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Lyon', 'Lyon', 'Parc OL'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Marseille', 'Marseille', 'Stade Vélodrome'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Metz', 'Metz', 'Stade Saint-Symphorien'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Monaco', 'Monaco', 'Stade Louis II'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Montpellier', 'Montpellier', 'Stade de la Mosson'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Nantes', 'Nantes', 'Stade de la Beaujoire'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Nice', 'Nice', 'Allianz Riviera'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Paris Saint-Germain', 'Paris SG', 'Parc des Princes'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Rennes', 'Rennes', 'Roazhon Park'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Saint-Étienne', 'St Etienne', 'Stade Geoffroy-Guichard'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Strasbourg', 'Strasbourg', 'Stade de la Meinau'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Toulouse', 'Toulouse', 'Stadium Municipal'),
((SELECT id from LEAGUES WHERE name='France Ligue 1'), 'Troyes', 'Troyes', 'Stade de lAube'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'FC Augsburg', 'Augsburg', 'WWK Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Hertha BSC', 'Hertha', 'Olympiastadion'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Werder Bremen', 'Werder Bremen', 'Weser-Stadion'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Borussia Dortmund', 'Dortmund', 'Signal Iduna Park'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Eintracht Frankfurt', 'Ein Frankfurt', 'Commerzbank-Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'SC Freiburg', 'Freiburg', 'Schwarzwald-Stadion'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Hamburger SV', 'Hamburg', 'Volksparkstadion'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Hannover 96', 'Hannover', 'HDI-Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), '1899 Hoffenheim', 'Hoffenheim', 'Wirsol Rhein-Neckar-Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), '1. FC Köln', 'FC Koln', 'RheinEnergieStadion'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'RB Leipzig', 'RB Leipzig', 'Red Bull Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Bayer Leverkusen', 'Leverkusen', 'BayArena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Mainz 05', 'Mainz', 'Opel Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Borussia Mönchengladbach', 'M''gladbach', 'Borussia-Park'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Bayern Munich', 'Bayern Munich', 'Allianz Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'Schalke 04', 'Schalke 04', 'Veltins-Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'VfB Stuttgart', 'Stuttgart', 'Mercedes-Benz Arena'),
((SELECT id from LEAGUES WHERE name='German Bundesliga'), 'VfL Wolfsburg', 'Wolfsburg', 'Volkswagen Arena'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Atalanta', 'Atalanta', 'Stadio Atleti Azzurri dItalia'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Benevento', 'Benevento', 'Stadio Ciro Vigorito'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Bologna', 'Bologna', 'Stadio Renato DallAra'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Cagliari', 'Cagliari', 'Sardegna Arena'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Chievo', 'Chievo', 'Stadio MarcAntonio Bentegodi'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Crotone', 'Crotone', 'Stadio Ezio Scida'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Fiorentina', 'Fiorentina', 'Stadio Artemio Franchi'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Genoa', 'Genoa', 'Stadio Luigi Ferraris'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Hellas Verona', 'Verona', 'Stadio MarcAntonio Bentegodi'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Internazionale', 'Inter', 'San Siro'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Juventus', 'Juventus', 'Allianz Stadium'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Lazio', 'Lazio', 'Stadio Olimpico'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Milan', 'Milan', 'San Siro'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Napoli', 'Napoli', 'Stadio San Paolo'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Roma', 'Roma', 'Stadio Olimpico'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Sampdoria', 'Sampdoria', 'Stadio Luigi Ferraris'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Sassuolo', 'Sassuolo', 'Mapei Stadium – Città del Tricolore '),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'SPAL', 'Spal', 'Paolo Mazza'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Torino', 'Torino', 'Stadio Olimpico Grande Torino'),
((SELECT id from LEAGUES WHERE name='Italy Serie A'), 'Udinese', 'Udinese', 'Stadio Friuli-Dacia Arena'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Alavés', 'Alaves', 'Mendizorrotza'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Athletic Bilbao', 'Ath Bilbao', 'San Mamés'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Atlético Madrid', 'Ath Madrid', 'Vicente Calderón'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Barcelona', 'Barcelona', 'Camp Nou'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Celta Vigo', 'Celta', 'Balaídos'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Deportivo La Coruña', 'La Coruna', 'Riazor'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Eibar', 'Eibar', 'Ipurua'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Espanyol', 'Espanol', 'RCDE Stadium'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Getafe', 'Getafe', 'Coliseum Alfonso Pérez'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Girona', 'Girona', 'Montilivi'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Las Palmas', 'Las Palmas', 'Gran Canaria'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Leganés', 'Leganes', 'Butarque'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Levante', 'Levante', 'Ciutat de València'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Málaga', 'Malaga', 'La Rosaleda'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Real Betis', 'Betis', 'Benito Villamarín'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Real Madrid', 'Real Madrid', 'Santiago Bernabéu'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Real Sociedad', 'Sociedad', 'Anoeta'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Sevilla', 'Sevilla', 'Ramón Sánchez Pizjuán'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Valencia', 'Valencia', 'Mestalla'),
((SELECT id from LEAGUES WHERE name='Spanish La Liga'), 'Villarreal', 'Villarreal', 'Estadio de la Cerámica'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'ADO Den Haag', 'Den Haag', 'Cars Jeans Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Ajax', 'Ajax', 'Amsterdam ArenA'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'AZ', 'AZ Alkmaar', 'AFAS Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Excelsior', 'Excelsior', 'Van Donge & De Roo Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Feyenoord', 'Feyenoord', 'Stadion Feijenoord'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'FC Groningen', 'Groningen', 'Noordlease Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'sc Heerenveen', 'Heerenveen', 'Abe Lenstra Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Heracles Almelo', 'Heracles', 'Polman Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'NAC Breda', 'NAC Breda', 'Rat Verlegh Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'PEC Zwolle', 'Zwolle', 'MAC³PARK stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'PSV', 'PSV Eindhoven', 'Philips Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Roda JC Kerkrade', 'Roda', 'Parkstad Limburg Stadion'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Sparta Rotterdam', 'Sparta Rotterdam', 'Het Kasteel'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'FC Twente', 'Twente', 'De Grolsch Veste'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'FC Utrecht', 'Utrecht', 'Stadion Galgenwaard'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Vitesse', 'Vitesse', 'GelreDome'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'VVV-Venlo', 'VVV Venlo', 'Seacon Stadion - De Koel -'),
((SELECT id from LEAGUES WHERE name='Holland Eredivisie'), 'Willem II', 'Willem II', 'Koning Willem II-stadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Anderlecht', 'Anderlecht', 'Constant Vanden Stock Stadium'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Antwerp', 'Antwerp', 'Bosuilstadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Charleroi', 'Charleroi', 'Stade du Pays de Charleroi'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Club', 'Club Brugge', 'Jan Breydel Stadium'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Eupen', 'Eupen', 'Kehrweg Stadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Genk', 'Genk', 'Luminus Arena'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Gent', 'Gent', 'Ghelamco Arena'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Kortrijk', 'Kortrijk', 'Guldensporen Stadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Lokeren', 'Lokeren', 'Daknamstadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Mechelen', 'Mechelen', 'AFAS-stadion Achter de Kazerne'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Mouscron', 'Mouscron', 'Stade Le Canonnier'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Oostende', 'Oostende', 'Versluys Arena'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Sint-Truiden', 'St Truiden', 'Stayen'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Standard', 'Standard', 'Stade Maurice Dufrasne'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Waasland', 'Waasland-Beveren', 'Freethiel Stadion'),
((SELECT id from LEAGUES WHERE name='Belgium First Division A'), 'Zulte', 'Waregem', 'Regenboogstadion'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Belenenses', 'Belenenses', 'Estádio do Restelo'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Benfica', 'Benfica', 'Estádio da Luz'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Boavista', 'Boavista', 'Estádio do Bessa'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Braga', 'Sp Braga', 'Estádio Municipal de Braga'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Chaves', 'Chaves', 'Estádio Municipal Eng. Manuel Branco Teixeira'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Desportivo das Aves', 'Aves', 'Estádio do CD Aves'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Estoril', 'Estoril', 'Estádio António Coimbra da Mota'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Feirense', 'Feirense', 'Estádio Marcolino de Castro'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Marítimo', 'Maritimo', 'Estádio do Marítimo'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Moreirense', 'Moreirense', 'Parque de Jogos Comendador Joaquim de Almeida Freitas'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Paços de Ferreira', 'Pacos Ferreira', 'Estádio Capital do Móvel'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Porto', 'Porto', 'Estádio do Dragão'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Portimonense', 'Portimonense', 'Estádio Municipal de Portimão'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Rio Ave', 'Rio Ave', 'Estádio dos Arcos'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Sporting CP', 'Sp Lisbon', 'Estádio José Alvalade'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Tondela', 'Tondela', 'Estádio João Cardoso'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Vitória de Guimarães', 'Guimaraes', 'Estádio D. Afonso Henriques'),
((SELECT id from LEAGUES WHERE name='Portugal Primeira Liga'), 'Vitória de Setúbal', 'Setubal', 'Estádio do Bonfim'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Akhisar Belediyespor', 'Akhisar Belediyespor', 'Manisa 19 Mayıs Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Alanyaspor', 'Alanyaspor', 'Alanya Oba Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Antalyaspor', 'Antalyaspor', 'Antalya Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Beşiktaş', 'Besiktas', 'Vodafone Park'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Bursaspor', 'Bursaspor', 'Timsah Arena'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Fenerbahçe', 'Fenerbahce', 'Ülker Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Galatasaray', 'Galatasaray', 'Türk Telekom Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Gençlerbirliği', 'Genclerbirligi', 'Ankara 19 Mayıs Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Göztepe', 'Goztep', 'Bornova Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'İstanbul Başakşehir', 'Buyuksehyr', 'Başakşehir Fatih Terim Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Kardemir Karabükspor', 'Karabukspor', 'Dr. Necmettin Şeyhoğlu Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Kasımpaşa', 'Kasimpasa', 'Recep Tayyip Erdoğan Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Kayserispor', 'Kayserispor', 'Kadir Has Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Konyaspor', 'Konyaspor', 'Konya Büyükşehir Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Osmanlıspor', 'Osmanlispor', 'Osmanlı Stadyumu'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Sivasspor', 'Sivasspor', 'Sivas Arena'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Trabzonspor', 'Trabzonspor', 'Şenol Güneş Stadium'),
((SELECT id from LEAGUES WHERE name='Turkish Süper Lig'), 'Yeni Malatyaspor', 'Yeni Malatyaspor', 'Malatya İnönü Stadium'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Aberdeen', 'Aberdeen', 'Pittodrie Stadium'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Celtic', 'Celtic', 'Celtic Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Dundee', 'Dundee', 'Dens Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Hamilton Academical', 'Hamilton', 'New Douglas Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Heart of Midlothian', 'Hearts', 'Tynecastle Stadium'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Hibernian', 'Hibernian', 'Easter Road'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Kilmarnock', 'Kilmarnock', 'Rugby Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Motherwell', 'Motherwell', 'Fir Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Partick Thistle', 'Partick', 'Firhill Stadium'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Rangers', 'Rangers', 'Ibrox Stadium'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'Ross County', 'Ross County', 'Victoria Park'),
((SELECT id from LEAGUES WHERE name='Scotland Premiership'), 'St Johnstone', 'St Johnstone', 'McDiarmid Park');