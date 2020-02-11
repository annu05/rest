<?php
 $db_connection = pg_connect("host=localhost port=5434 dbname=postgres user=postgres password=123");
 $result = pg_query($db_connection, "SELECT * FROM rest");
echo "<table>";
while($row=pg_fetch_assoc($result)){echo "<tr>";
    echo "<td align='center' width='200'>" . $row['clientContext'] . "</td>";
    echo "<td align='center' width='200'>" . $row['location'] . "</td>";
    echo "<td align='center' width='200'>" . $row['uId'] . "</td>";
    echo "<td align='center' width='200'>" . $row['users'] . "</td>";
    echo "</tr>";}echo "</table>";