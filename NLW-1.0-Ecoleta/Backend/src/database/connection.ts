import knex from 'knex';
import path from 'path'; // Lib para tratar com caminhos de arquivos em Node

const connection = knex({
    client: 'sqlite3',
    connection: {
      filename: path.resolve(__dirname, 'database.sqlite'),
    },
    useNullAsDefault: true
});

export default connection;