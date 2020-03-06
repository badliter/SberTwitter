import { Model, Server } from "miragejs";

const makeServer = ({ environment = "development" } = {}) => (
    new Server({
        environment,

        models: {
            tweet: Model,
        },

        seeds(server) {
            server.create("tweet", {
                user_id: "1", twitt_id: "1", content: "hello world", creation_time: "1583395200",
            });
            server.create("tweet", {
                user_id: "1", twitt_id: "2", content: "hi", creation_time: "1583395200",
            });
        },

        routes() {
            this.urlPrefix = process.env.API_URL;

            this.get("/getAllTwitts", (schema) => schema.tweets.all());
        },
    })
);

export default makeServer;
