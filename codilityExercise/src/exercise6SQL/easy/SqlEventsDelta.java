package exercise6SQL.easy;

//Given a table events with the following structure:
//
//        create table events (
//        event_type integer not null,
//        value integer not null,
//        time timestamp not null,
//        unique(event_type, time)
//        );
//        write an SQL query that, for each event_type that has been registered more than once, returns the difference between
//        the latest (i.e. the most recent in terms of time)
//        and the second latest value. The table should be ordered by event_type (in ascending order).
//
//        For example, given the following data:
//
//        event_type | value      | time
//        ------------+------------+--------------------
//        2          | 5          | 2015-05-09 12:42:00
//        4          | -42        | 2015-05-09 13:19:57
//        2          | 2          | 2015-05-09 14:48:30
//        2          | 7          | 2015-05-09 12:54:39
//        3          | 16         | 2015-05-09 13:19:57
//        3          | 20         | 2015-05-09 15:01:09
//        your query should return the following rowset:
//
//        event_type | value
//        ------------+-----------
//        2          | -5
//        3          | 4
//        For the event_type 2, the latest value is 2 and the second latest value is 7, so the difference between them is −5.
//
//        The names of the columns in the rowset don't matter, but their order does.
public class SqlEventsDelta {
//    You can achieve this by using the LAG window function along with the PARTITION BY and ORDER BY clauses.
//        Here's the SQL query for your requirement:
//
//    WITH RankedEvents AS (
//    SELECT
//            event_type,
//            value,
//            ROW_NUMBER() OVER (PARTITION BY event_type ORDER BY time DESC) AS row_num
//    FROM
//            events
//)
//    SELECT
//            event_type,
//    value - LAG(value) OVER (PARTITION BY event_type ORDER BY time DESC) AS value_difference
//    FROM
//            RankedEvents
//    WHERE
//            row_num = 1
//    AND value_difference IS NOT NULL;

//    This query uses a Common Table Expression (CTE) named RankedEvents
//    to assign row numbers to each row within each event_type partition
//    based on the descending order of time.
//    Then, it selects the rows where row_num is 1 (i.e., the latest event for each event_type)
//    and calculates the difference between the latest and second latest values using the LAG function.
//    The value_difference is computed only for rows where the difference is not NULL.
//
//    This query should produce the desired result with the specified ordering by event_type.


}
