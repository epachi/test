package exercise6SQL.medium;

//You are given two tables, teams and matches, with the following structures:

//        create table teams (
//        team_id integer not null,
//        team_name varchar(30) not null,
//        unique(team_id)
//        );
//
//        create table matches (
//        match_id integer not null,
//        host_team integer not null,
//        guest_team integer not null,
//        host_goals integer not null,
//        guest_goals integer not null,
//        unique(match_id)
//        );
//        Each record in the table teams represents a single soccer team. Each record in the table matches represents a finished match between two teams. Teams (host_team, guest_team) are represented by their IDs in the teams table (team_id). No team plays a match against itself. You know the result of each match (that is, the number of goals scored by each team).
//
//        You would like to compute the total number of points each team has scored after all the matches described in the table. The scoring rules are as follows:
//
//        If a team wins a match (scores strictly more goals than the other team), it receives three points.
//        If a team draws a match (scores exactly the same number of goals as the opponent), it receives one point.
//        If a team loses a match (scores fewer goals than the opponent), it receives no points.
//        Write an SQL query that returns a ranking of all teams (team_id) described in the table teams. For each team you should provide its name and the number of points it received after all described matches (num_points). The table should be ordered by num_points (in decreasing order). In case of a tie, order the rows by team_id (in increasing order).
//
//        For example, for:
//
//        teams:
//
//        team_id | team_name
//        ---------+---------------
//        10      | Give
//        20      | Never
//        30      | You
//        40      | Up
//        50      | Gonna
//
//
//        matches:
//
//        match_id | host_team | guest_team | host_goals | guest_goals
//        ----------+-----------+------------+------------+-------------
//        1        | 30        | 20         | 1          | 0
//        2        | 10        | 20         | 1          | 2
//        3        | 20        | 50         | 2          | 2
//        4        | 10        | 30         | 1          | 0
//        5        | 30        | 50         | 0          | 1
//        your query should return:
//
//        team_id | team_name | num_points
//        ---------+-----------+------------
//        20      | Never     | 4
//        50      | Gonna     | 4
//        10      | Give      | 3
//        30      | You       | 3
//        40      | Up        | 0


public class SqlWorldCup {
//    You can use the following SQL query to calculate
//    the total number of points for each team and return the ranking:

//    WITH TeamPoints AS (
//            SELECT
//                    team_id,
//            team_name,
//            SUM(CASE
//                    WHEN team_id = host_team AND host_goals > guest_goals THEN 3
//                    WHEN team_id = guest_team AND guest_goals > host_goals THEN 3
//                    WHEN host_goals = guest_goals AND (team_id = host_team OR team_id = guest_team) THEN 1
//    ELSE 0
//    END) AS num_points
//    FROM
//            teams
//    LEFT JOIN matches ON team_id = host_team OR team_id = guest_team
//    GROUP BY
//    team_id, team_name
//)
//
//    SELECT
//            team_id,
//            team_name,
//    COALESCE(num_points, 0) AS num_points
//    FROM
//            TeamPoints
//    ORDER BY
//    num_points DESC, team_id;


//    This query uses a Common Table Expression (CTE) named TeamPoints to calculate the total number of points
//    for each team based on the scoring rules provided. The CTE includes a SUM function with CASE statements to handle the different scoring scenarios.
//    The main query then selects the team_id, team_name, and num_points from the CTE, ensuring that teams with no points are included using COALESCE.
//    The final result is ordered by num_points in descending order and team_id in ascending order.
}
