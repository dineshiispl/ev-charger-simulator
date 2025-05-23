# EV Charger Simulator

This project provides a simulation environment for modeling multiple Electric Vehicle (EV) chargers operating concurrently on a shared power grid. The simulator can be used to analyze charging strategies, manage grid load, and develop algorithms for efficient energy distribution among EVs.

## Features

- **Concurrent Charging Simulation**: Simulate how multiple EVs charge simultaneously and interact with the power grid.
- **Grid Load Management**: Evaluate different strategies to handle grid overload and balance distribution.
- **Customizable Parameters**: Configure number of EVs, grid capacity, charging rates, and other relevant parameters.
- **Statistics and Reporting**: Generate reports and statistics to analyze system performance.
- **Extensible Design**: Built to allow enhancement with new charging algorithms, grid management policies, or EV types.

## Getting Started

### Prerequisites

- Java 11 or newer
- IntelliJ IDEA or another Java IDE

### Building the Project

1. Clone the repository:
    ```shell
    git clone <repository-url>
    cd ev-charger-simulator
    ```
2. Open in IntelliJ IDEA or another Java-supporting IDE.
3. Build the project using the IDE's build features or with `javac`.

### Running the Simulator

You can run the main class in your IDE or from the command line if a main entry point is provided. Configuration options (such as the number of EVs or grid parameters) may be adjustable within code or via configuration files.

## Usage

Typical use cases include:
- Testing load-balancing algorithms for EV charging.
- Research and academic demonstrations.
- Evaluating the impact of EV charging on grid stability.

## Contribution

Contributions are welcome! Feel free to:
- Submit bug reports and feature requests.
- Fork the repository and open pull requests.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

For questions or support, please open an issue in this repository.

---

*This simulator is intended for research, experimentation, and educational purposes, providing insight into the challenges and solutions of integrating EV charging with existing power grids.*