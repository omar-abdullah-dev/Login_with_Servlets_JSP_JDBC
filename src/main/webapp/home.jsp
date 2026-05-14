<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Management Table</title>
    <style>
        /* Table Layout Styling */
        .table-container {
            width: 90%;
            margin: 30px auto;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
        }

        th {
            background-color: #2c3e50;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
            letter-spacing: 0.5px;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        /* Action Buttons Wrapper */
        .action-buttons {
            display: flex;
            gap: 8px;
        }

        /* Core Button Styles */
        .btn {
            padding: 8px 14px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 600;
            font-size: 13px;
            transition: background-color 0.2s ease;
        }

        /* Specific Button Types */
        .btn-edit {
            background-color: #3498db;
            color: white;
        }

        .btn-edit:hover {
            background-color: #2980b9;
        }

        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }

        .btn-delete:hover {
            background-color: #c0392b;
        }

        /* Add Button Footer Row styling */
        .table-footer {
            margin-top: 15px;
            display: flex;
            justify-content: flex-end; /* Aligns the add button to the right */
        }

        .btn-add {
            background-color: #2ecc71;
            color: white;
            padding: 10px 20px;
            font-size: 14px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .btn-add:hover {
            background-color: #27ae60;
        }

        /* Password masking for security visualization */
        .password-cell {
            font-family: monospace;
            letter-spacing: 2px;
        }
    </style>

</head>
<body>

    <div class="table-container">
        <h2>Users Registry</h2>

        <table>
        <%-- the Header of the table --%>
            <thead>
            <tr>
                <th>ID</th>
                <th>Email Address</th>
                <th>Password</th>
                <th>Operations</th>
            </tr>
            </thead>

            <tbody>
            <!-- Loop through database records here -->
            <tr>
                <td>1</td>
                <td>john.doe@example.com</td>
                <td class="password-cell">••••••••</td>
                <td>
                    <div class="action-buttons">
                        <button class="btn btn-edit" onclick="editUser(1)">Edit</button>
                        <button class="btn btn-delete" onclick="deleteUser(1)">Delete</button>
                    </div>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>jane.smith@example.com</td>
                <td class="password-cell">••••••••</td>
                <td>
                    <div class="action-buttons">
                        <button class="btn btn-edit" onclick="editUser(2)">Edit</button>
                        <button class="btn btn-delete" onclick="deleteUser(2)">Delete</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <!-- Add button container at the end of the table -->
        <div class="table-footer">
            <button class="btn btn-add" onclick="addUser()">+ Add New User</button>
        </div>
    </div>

    <script>
        // Placeholder JavaScript functions for operations
        function editUser(id) {
            console.log("Trigger edit flow for user ID: " + id);
        }

        function deleteUser(id) {
            if(confirm("Are you sure you want to delete user ID " + id + "?")) {
                console.log("Trigger delete action for user ID: " + id);
            }
        }

        function addUser() {
            console.log("Open add user form/modal");
        }
    </script>

</body>
</html>
